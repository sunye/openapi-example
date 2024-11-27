package org.atlanmod.spring.openapi.api;

import org.atlanmod.spring.openapi.api.PetsApiDelegate;
import org.atlanmod.spring.openapi.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PetsApiDelegateImpl implements PetsApiDelegate {

    private final List<Pet> pets = new ArrayList<>();

    @Override
    public ResponseEntity<Pet> findPetById(Long id) {
        Optional<Pet> pet = getPets().stream().findFirst();
        return pet.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    private List<Pet> getPets() {
        Pet pet0 = new Pet();
        pet0.setId(1L);
        pet0.setName("Chessie Cat");
        pet0.setTag("cat");
        pets.add(pet0);
        return pets;
    }

    @Override
    public ResponseEntity<List<Pet>> findPets(List<String> tags, Integer limit)  {
        List<Pet> pets = getPets();
        return ResponseEntity.ok(pets);
    }

}
