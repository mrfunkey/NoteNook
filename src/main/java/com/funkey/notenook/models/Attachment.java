package com.funkey.notenook.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity (name = "Attachment")
@Table(name = "Attachment")
@Data
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;
    private String type;
}
