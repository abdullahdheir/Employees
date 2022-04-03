package abddhe.emloyee_list;

public class Employee {

        int emp_id;
        String emp_jop;
        String emp_name;
        String emp_depart;
        int image;
        public Employee(){}

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_jop() {
        return emp_jop;
    }

    public void setEmp_jop(String emp_jop) {
        this.emp_jop = emp_jop;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_depart() {
        return emp_depart;
    }

    public void setEmp_depart(String emp_depart) {
        this.emp_depart = emp_depart;
    }
}
