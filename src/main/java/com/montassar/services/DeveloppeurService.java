package com.montassar.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.montassar.entities.Developpeur;

public interface DeveloppeurService {
Developpeur saveDeveloppeur(Developpeur d);
Developpeur updateDeveloppeur(Developpeur d);
void deleteDeveloppeur(Developpeur d);
void deleteDeveloppeurById(Long id);
Developpeur getDeveloppeur(Long id);
List<Developpeur> getAllDeveloppeurs();
Page<Developpeur> getAllDeveloppeursParPage(int page, int size);
}
