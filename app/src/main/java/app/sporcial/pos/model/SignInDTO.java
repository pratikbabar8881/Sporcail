package app.sporcial.pos.model;

public class SignInDTO
{

    private String email,password,phone_no,username;

 /*   public SignInDTO(String email, String password, String phone_no, String username) {
        this.email = email;
        this.password = password;
        this.phone_no = phone_no;
        this.username = username;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SignInDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
