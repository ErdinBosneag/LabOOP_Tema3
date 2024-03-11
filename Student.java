public class Student implements Comparable<Student>{
    protected int prezenta;
    protected String nume;
    protected String prenume;

    public Student(int prezenta, String nume, String prenume) {
        this.prezenta = prezenta;
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPrezenta() {
        return prezenta;
    }

    public void setPrezenta(int prezenta) {
        this.prezenta = prezenta;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public int compareTo(Student o) {
        if(this.prezenta == o.getPrezenta()) return 0;
        else if (this.prezenta > o.getPrezenta()) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "prezenta=" + prezenta +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
