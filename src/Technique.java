public class Technique {
  private String name;
  private Integer index;

  Technique () { // Constructor by default

  }

  Technique (String name, Integer index) { // Constructor with parameters
    this.name = name;
    this.index = index;
  }

  // Override of method equals()
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Technique technique = (Technique) obj;
    return index == technique.index && (name != null ? name.equals(technique.name) : technique.name == null);
  }

  // Override of method hashCode()
  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + index;
    return result;
  }

  // Override of method toString()
  @Override
  public String toString() {
    return " {name=" + name + ", index=" + index + "}";
  }

  // Getters and setters
  public void name(String name) {
    this.name = name;
  }

  public void set_index(Integer index) {
    this.index = index;
  }

  public String get_name() {
    return name;
  }

  public Integer get_index() {
    return index;
  }
}
