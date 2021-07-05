package sample.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

//обработчики событий устанавливаются в конструкторе Controller
public class FDMenuBar extends MenuBar {

    public FDMenuBar() {
        getMenus().addAll(new FileMenu(), new PlayerMenu());
    }

    class PlayerMenu extends Menu {
        PlayerMenu() {
            super("Player");
            getItems().addAll(new AddMenu(), new FindMenu(), new DeleteMenu());
        }
    }

    class AddMenu extends MenuItem {
        AddMenu() {
            super("Add");
        }
    }

    class FindMenu extends MenuItem {
        FindMenu() {
            super("Find");
        }
    }

    class DeleteMenu extends MenuItem {
        DeleteMenu() {
            super("Delete");
        }
    }

    class FileMenu extends Menu {

        FileMenu() {
            super("File");
            getItems().addAll(new SaveMenu(), new OpenMenu());
        }

        class SaveMenu extends MenuItem {
            SaveMenu() {
                super("Save");
            }
        }

        class OpenMenu extends MenuItem {
            OpenMenu() {
                super("Open");
            }
        }
    }
}
