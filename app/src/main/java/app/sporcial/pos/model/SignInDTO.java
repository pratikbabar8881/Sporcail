package app.sporcial.pos.model;

public class SignInDTO
{

    private String email,password,con_password,mobile;



    public SignInDTO(String email, String password ,String con_password ,String mobile)
    {
        this.email = email;
        this.password = password;
        this.con_password = con_password;
        this.mobile = mobile;

    }


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

    public String getCon_password() {
        return con_password;
    }

    public void setCon_password(String con_password) {
        this.con_password = con_password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "SignInDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", con_password='" + con_password + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
