package com.p5.adoptions.service.exceptions;

public class ShelterLocationException extends RuntimeException{
    //Exceptiile sunt de 2 feluri: Checked si Unchecked
        //Exceptii Checked: cele care sunt verificate la timpul compilarii. Sunt cele care tin de limbaj(nu punem punct si virgula, acolada, nu definesc bine o variabila etc)
        //Exceptii Unchecked: cele care sunt verificate la runtime(restul greselilor). Ele apar in momentul executiei codului.
        //Erorile - nu tin de programator(ex: se ia curentul, nu merge netul).

    private String message;

    public ShelterLocationException(String message) {
        super(message);
    }
}
