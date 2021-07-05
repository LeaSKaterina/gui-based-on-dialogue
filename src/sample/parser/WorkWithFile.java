package sample.parser;

import javafx.collections.FXCollections;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import sample.controller.Controller;
import sample.model.PlayerModel;
import sample.model.SquadEnum;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class WorkWithFile{

    private final Stage primaryStage;
    private final Controller controller;

    public WorkWithFile(Stage primaryStage, Controller controller) {
        this.controller = controller;
        this.primaryStage = primaryStage;
    }

    public void saveDoc() {
        FileChooser saveDocChooser = new FileChooser();

        saveDocChooser.setTitle("Save document");
        saveDocChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Все файлы", "*.*"),
                new FileChooser.ExtensionFilter("XML-документ", "*.xml")
        );
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); //Помогает приложениям получить синтаксический анализатор, который производит деревья объекта ДОМА из XML-документов.
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder(); //Используя этот класс получаем Document из XML.

            //Корневой элемент
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("root");
            document.appendChild(rootElement);

            for (PlayerModel player : controller.getModel().getListOfPlayers()) {
                Element playerElement = document.createElement("player");
                rootElement.appendChild(playerElement);

                decideElements(document, playerElement, "firstName", String.valueOf(player.getFirstName()));
                decideElements(document, playerElement, "middleName", String.valueOf(player.getMiddleName()));
                decideElements(document, playerElement, "lastName", String.valueOf(player.getLastName()));
                decideElements(document, playerElement, "birthDate", player.getBirthDate().toString());
                decideElements(document, playerElement, "teamName",
                        player.getTeamName());
                decideElements(document, playerElement, "homeTown", player.getHomeTown());
                decideElements(document, playerElement, "squad",
                        player.getSquad().toString());
                decideElements(document, playerElement, "position", player.getPosition());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            StreamResult streamResult = new StreamResult(saveDocChooser.showSaveDialog(primaryStage));
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | TransformerException pce) {
            System.out.println(pce.getLocalizedMessage());
            pce.printStackTrace();
        }
    }

    private void decideElements(Document document, Element playerElement,
                                String playerProperty, String playerPropertyValue) {
        Element element = document.createElement(playerProperty);
        element.appendChild(document.createTextNode(playerPropertyValue));
        playerElement.appendChild(element);
    }

    public void openDoc() {
        FileChooser openDocChooser = new FileChooser();

        openDocChooser.setTitle("Open document");
        openDocChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Все файлы", "*.*"),
                new FileChooser.ExtensionFilter("XML-документы", "*.xml")
        );

        try {
            ArrayList<PlayerModel> playerList = new ArrayList<>(0);

            try {
                SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                SAXParser saxParser = saxParserFactory.newSAXParser();
                MyHandler myHandler = new MyHandler();
                saxParser.parse(openDocChooser.showOpenDialog(primaryStage), myHandler);
                playerList = myHandler.getPersonList();
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }

            controller.getModel().setListOfPlayers(FXCollections.observableArrayList(playerList));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public class MyHandler extends DefaultHandler {
        private ArrayList<PlayerModel> playerList = null;
        private PlayerModel product = null;
        private StringBuilder data = null;

        public ArrayList<PlayerModel> getPersonList() {
            return playerList;
        }

        private boolean
                firstNameInput = false,
                middleNameInput = false,
                lastNameInput = false,
                birthDateInput = false,
                teamNameInput = false,
                homeTownInput = false,
                squadInput = false,
                positionInput = false;

        @Override
        public void startElement(String uri, String localName, String nodeName, Attributes attributes) {

            if (nodeName.equalsIgnoreCase("player")) {
                product = new PlayerModel();
                if (playerList == null)
                    playerList = new ArrayList<>();

            } else if (nodeName.equalsIgnoreCase("firstName")) {
                firstNameInput = true;
            } else if (nodeName.equalsIgnoreCase("middleName")) {
                middleNameInput = true;
            } else if (nodeName.equalsIgnoreCase("lastName")) {
                lastNameInput = true;
            } else if (nodeName.equalsIgnoreCase("birthDate")) {
                birthDateInput = true;
            } else if (nodeName.equalsIgnoreCase("teamName")) {
                teamNameInput = true;
            } else if (nodeName.equalsIgnoreCase("homeTown")) {
                homeTownInput = true;
            } else if (nodeName.equalsIgnoreCase("squad")) {
                squadInput = true;
            } else if (nodeName.equalsIgnoreCase("position")) {
                positionInput = true;
            }
            data = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (firstNameInput) {
                product.setFirstName(data.toString());
                firstNameInput = false;
            } else if (middleNameInput) {
                product.setMiddleName(data.toString());
                middleNameInput = false;
            } else if (lastNameInput) {
                product.setLastName(data.toString());
                lastNameInput = false;
            } else if (birthDateInput) {
                Calendar calendar = parseCalendar();
                product.setBirthDate(calendar.getTime());
                birthDateInput = false;
            } else if (teamNameInput) {
                product.setTeamName(data.toString());
                teamNameInput = false;
            } else if (homeTownInput) {
                product.setHomeTown(data.toString());
                homeTownInput = false;
            } else if (squadInput) {
                product.setSquad(SquadEnum.initSquad(data.toString()));
                squadInput = false;
            } else if (positionInput) {
                product.setPosition(data.toString());
                positionInput = false;
            }

            if (qName.equalsIgnoreCase("player")) {
                playerList.add(product);
            }
        }

        private Calendar parseCalendar() {
            String[] strings = data.toString().split("[\\s:]");
            int month = strings[1].equals("Jan") ? 0 : strings[1].equals("Feb") ? 1 :
                    strings[1].equals("Mar") ? 2 : strings[1].equals("Apr") ? 3 :
                            strings[1].equals("May") ? 4 : strings[1].equals("Jun") ? 5 :
                                    strings[1].equals("Jul") ? 6 : strings[1].equals("Aug") ? 7 :
                                            strings[1].equals("Sep") ? 8 : strings[1].equals("Oct") ? 9 :
                                                    strings[1].equals("Nov") ? 10 : 11;

            return new GregorianCalendar(
                    Integer.parseInt(strings[7]),
                    month,
                    Integer.parseInt(strings[2]),
                    Integer.parseInt(strings[3]),
                    Integer.parseInt(strings[4])
            );
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            data.append(new String(ch, start, length));
        }
































    }




}
