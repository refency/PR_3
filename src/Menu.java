import java.util.ArrayList;

class Menu {
  static void all_menu() { // Main menu call function
    main_menu();
    menu_type_defifinition(Functions.create_list());
  }

  static void all_menu(ArrayList<Technique> techniques) { // Overloading method
    main_menu();
    menu_type_defifinition(techniques);
  }

  static void main_menu() { // Output in console all points of menu
    System.out.println(Functions.Color("yellow") + "Input the command" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "1" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Add new element in collection" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "2" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Delete element from collection by index" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "3" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Output the collection in console" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "4" + Functions.Color("reset") + " - " + Functions.Color("blue")
                      + "Compare two elements of collection" + Functions.Color("reset"));

    System.out.println(Functions.Color("green") + "5" + Functions.Color("reset") + " - " + Functions.Color("red")
                      + "exit" + Functions.Color("reset"));
  }

  static void menu_type_defifinition(ArrayList<Technique> techniques) { // Main menu to choose needed point
    String input = Functions.input_text("Input menu item: ");

    switch (input) {
      case "1":
        Functions.create_element(techniques);
        all_menu(techniques);
      case "2":
        Functions.delete_element(techniques);
        all_menu(techniques);
      case "3":
        Functions.print_all(techniques);
        all_menu(techniques);
      case "4":
        Functions.compare_elements(techniques);
        all_menu(techniques);
      case "5":
        System.exit(0);
      default:
        all_menu(techniques);
    }
  }
}