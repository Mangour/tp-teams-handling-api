package fr.sorbonne.paris.nord.university.tpteamshandlingapi.exception;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(String message) {
        super(message);
    }
}
