package fr.sorbonne.paris.nord.university.tpteamshandlingapi.dto;

public class PlayerDto {

    private String name;

    public PlayerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
