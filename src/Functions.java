import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Functions {
  public static String input_text(String label) { // Input text from console
    try {
      System.out.print(Color("yellow") + label + Color("reset"));
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Call of system.in to read input from console by bufferedreader
      String text = reader.readLine(); // Write string with stream from buffer

      return text;
    } catch (IOException exception) {
      exception.printStackTrace();
      return exception.toString();
    }
  }

  public static String Color(String color) { // Function of symbols of ANSI to change color of text in console
    switch(color) {
      case("red"):
        return "\u001B[31m";
      case("green"):
        return "\u001B[32m";
      case("blue"):
        return "\u001B[34m";
      case("reset"):
        return "\u001B[0m";
      case("yellow"):
        return "\u001B[33m";
      case("purple"):
        return "\u001B[35m";
      default:
        return "";
    }
  }

  public static ArrayList<Technique> create_list() { // This function create empty list at first call of one overloading method
    ArrayList<Technique> techniques = new ArrayList<Technique>();

    return techniques;
  }

  public static void create_element(ArrayList<Technique> techniques) { // Create element of collection
    print_classes();

    String field = input_text("Type the index of class want to add to collection: ");
    if(!check_int(field)) return;

    String class_type = check_field(techniques, field);

    switch (class_type) {
      case "1":
        techniques.add(new Technique(check_name(techniques), check_index(techniques)));
        break;
      case "2":
        techniques.add(new HouseholdEquipment(check_name(techniques), check_index(techniques), check_vendor(techniques), check_manufacturer_code(techniques)));
        break;
      case "3":
        techniques.add(new GardenEquipment(check_name(techniques), check_index(techniques), check_vendor(techniques), check_manufacturer_code(techniques)));
        break;
      case "4":
        techniques.add(new VehicleEquipment(check_name(techniques), check_index(techniques), check_vendor(techniques), check_manufacturer_code(techniques)));
        break;
      default:
        create_element(techniques);
    }
  }

  public static void delete_element(ArrayList<Technique> techniques) { // Deleted element from collection by typed index
    String index = input_text("Type the id object of collection to delete it: ");
    if (!check_int(index)) return;
    check_exist_elements(techniques, index);

    techniques.remove(Integer.parseInt(index));
  }

  public static void check_exist_elements(ArrayList<Technique> techniques, String index) { // Check that typed elements exist
    if (Integer.valueOf(index) > techniques.size() || Integer.valueOf(index) < 0) {
      System.out.println(Color("red") + "Typed of index of object is undefined" + Color("reset"));

      Menu.menu_type_defifinition(techniques);
    }
  }

  public static void print_all(ArrayList<Technique> techniques) { // Printed all elements of collection in console
    for (int i = 0; i < techniques.size(); i ++) {
      System.out.println("id=" + i + techniques.get(i));
    }
  }

  public static void compare_elements(ArrayList<Technique> techniques) { // Compare two choosen elements of collection by hashCode and equals
    String first_index = input_text("Type the id of first element to compare: ");
    check_int(first_index);
    check_exist_elements(techniques, first_index);

    String second_index = input_text("Type the id of second element to compare: ");
    check_int(second_index);
    check_exist_elements(techniques, second_index);

    if (techniques.get(Integer.parseInt(first_index)).hashCode() == techniques.get(Integer.parseInt(second_index)).hashCode()) {
      System.out.println(Color("green") + "Elements are equal by hashCode" + Color("reset"));
    } else {
      System.out.println(Color("red") + "Elements are not equal by hashCode" + Color("reset"));
    }

    if (techniques.get(Integer.parseInt(first_index)).equals(techniques.get(Integer.parseInt(second_index)))) {
    System.out.println(Color("green") + "Elements are equal by method equals" + Color("reset"));
    } else {
      System.out.println(Color("red") + "Elements are not equal by method equals" + Color("reset"));
    }
  }

  public static Boolean check_int(String index) { // Check variable is int
    try {
      Integer.parseInt(index);

      return true;
    } catch (Exception exception) {
      System.out.println(Color("red") + "Type of data was incorrect, need to type number" + Color("reset"));

      return false;
    }
  }

  public static String check_name(ArrayList<Technique> techniques) { // Check name by range
    String name = input_text("Type the name of technique: ");
    if (name.length() > 50) {
      System.out.println(Color("red") + "Name of technique is too large: " + Color("reset"));
      create_element(techniques);
    }
    if (name.length() < 5) {
      System.out.println(Color("red") + "Name of technique is too short: " + Color("reset"));
      create_element(techniques);
    }

    return name;
  }

  public static Integer check_index(ArrayList<Technique> techniques) { // Check index by range
    String index = input_text("Type the index of technique: ");

    try {
      Integer.parseInt(index);
    } catch (Exception exception) {
      fix_value();
      create_element(techniques);
    }

    if (String.valueOf(index).length() > 20) {
      System.out.println(Color("red") + "Index of object is too big: " + Color("reset"));
      create_element(techniques);
    }
    if (String.valueOf(index).length() < 5) {
      System.out.println(Color("red") + "Index of object is too small: " + Color("reset"));
      create_element(techniques);
    }

    return Integer.parseInt(index);
  }

  public static String check_vendor(ArrayList<Technique> techniques) { // Check vendor by range
    String vendor = input_text("Type the name of vendor: ");
    if (vendor.length() > 25) {
      System.out.println(Color("red") + "Name of vendor is too large: " + Color("reset"));
      create_element(techniques);
    }
    if (vendor.length() < 5) {
      System.out.println(Color("red") + "Name of vendor is too short: " + Color("reset"));
      create_element(techniques);
    }

    return vendor;
  }

  public static Integer check_manufacturer_code(ArrayList<Technique> techniques) { // Check manufacturer code by range
    String code = input_text("Type the manufacturer code of technique: ");

    try {
      Integer.parseInt(code);
    } catch (Exception exception) {
      fix_value();
      create_element(techniques);
    }

    if (String.valueOf(code).length() > 30) {
      System.out.println(Color("red") + "Code of object is too big: " + Color("reset"));
      create_element(techniques);
    }
    if (String.valueOf(code).length() < 8) {
      System.out.println(Color("red") + "Code of object is too small: " + Color("reset"));
      create_element(techniques);
    }

    return Integer.parseInt(code);
  }

  public static void fix_value() {
    System.out.println(Color("red") + "Data was incorrect, type corrected data: " + Color("reset"));
  }

  public static void print_classes() { // Print all classes to console interface
    System.out.println(Color("green") + "1." + Color("reset") + Color("yellow") + "Technique" + Color("reset"));
    System.out.println(Color("green") + "2." + Color("reset") + Color("yellow") + "Household" + Color("reset"));
    System.out.println(Color("green") + "3." + Color("reset") + Color("yellow") + "Garden" + Color("reset"));
    System.out.println(Color("green") + "4." + Color("reset") + Color("yellow") + "Vehicle" + Color("reset"));
  }

  public static String check_field(ArrayList<Technique> technique, String field) { // Checking exist class of object in list
    if (Integer.valueOf(field) > 4 || Integer.valueOf(field) < 0) {
      System.out.println(Color("red") + "Typed by you class do not exist" + Color("reset"));

      create_element(technique);
    }

    return field;
  }
}
