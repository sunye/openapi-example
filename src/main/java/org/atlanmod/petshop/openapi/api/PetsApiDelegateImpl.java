package org.atlanmod.petshop.openapi.api;

import org.atlanmod.petshop.openapi.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetsApiDelegateImpl implements PetsApiDelegate {

    private final List<Pet> pets = new ArrayList<>();

    @Override
    public ResponseEntity<Pet> findPetById(Long id) {
        Pet pet = getPets().stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
        if (pet != null) {
            return ResponseEntity.ok(pet);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    private List<Pet> getPets() {
        Pet pet0 = new Pet();
        pet0.setId(1L);
        pet0.setName("Chessie Cat");
        pet0.setTag("cat");
        pets.add(pet0);
        return pets;
    }

}
