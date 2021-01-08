package modele;

import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
public class Computer {
    private int id;
    private String name;
    private int companyId;
    private LocalDate introduced;
    private LocalDate discontinued;


    public Computer() {
    }

    public Computer(int id, String name, LocalDate introduced, LocalDate discontinued, int companyId) {
        this.id = id;
        this.name = name;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.companyId = companyId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public LocalDate getIntroduced() {
        return introduced;
    }

    public void setIntroduced(LocalDate introduced) {
        this.introduced = introduced;
    }

    public LocalDate getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(LocalDate discontinued) {
        this.discontinued = discontinued;
    }
}
