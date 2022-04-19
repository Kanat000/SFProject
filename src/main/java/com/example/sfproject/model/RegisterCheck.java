package com.example.sfproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCheck {
    private boolean correctName;
    private boolean correctSurname;
    private boolean correctEmail;
    private boolean correctPass;
}
