package com.funkey.notenook.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity (name = "Nook")
@Table(name = "Nook")
@Data
public class Nook {

    @Id
    @GeneratedValue
    private UUID id;

    private String passkey;
    private String name;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String lastAccessedDate;

    @OneToMany(mappedBy = "nook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories = new ArrayList<>();

    public String formattedDate(){
        if (this.createdDate == null){
            return null;
        }
        String[] splitDate = createdDate.toString().split("T");
        String yearMonthDay = splitDate[0];
        String[] dateElements =  yearMonthDay.split("-");
        String formattedDate = dateElements[1] + "-" + dateElements[2] + "-" + dateElements[0];

        return formattedDate;
    }


}
