package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
public class AlbumEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String albumId;
    private String userId;
    private String name;
    private String description;
 }