package bo;

public class Contact {
    private int id;
    private String lastName;
    private String firstName;
    private String phone;
    private String type;

    public Contact(String lastName, String firstName, String phone, String type) {
        this.lastName = firstName;
        this.firstName = lastName;
        this.phone = phone;
        this.type = type;
    }

    public Contact(int id, String lastName, String firstName, String phone, String type) {
        this.id = id;
        this.lastName = firstName;
        this.firstName = lastName;
        this.phone = phone;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact {" +
                "id=" + id +
                ", first name ='" + this.firstName + '\'' +
                ", last name ='" + this.lastName + '\'' +
                ", phone ='" + this.phone + '\'' +
                ", type ='" + this.type + '\'' +
                '}';
    }
}
