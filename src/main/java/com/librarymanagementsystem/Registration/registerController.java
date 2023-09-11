package com.librarymanagementsystem.Registration;

import com.librarymanagementsystem.Dto.Response.genericResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/duser")
public class registerController {

    private final registerService registerService;

    @GetMapping
    public ResponseEntity<genericResponse> getallusers(){
        genericResponse response = registerService.getallusers();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<genericResponse> addappUser(@RequestBody registerRequest request){
        genericResponse response = registerService.addDUser(request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<genericResponse> deleteallappUsers(){
        genericResponse response = registerService.deleteallduser();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }


    @DeleteMapping("{deleteByUsername}")
    public ResponseEntity<genericResponse> deleteByIsbnNumber(@PathVariable("deleteByUsername") String username){
        genericResponse response = registerService.deleteByUsername(username);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PutMapping("{updatebyUsername}")
    public ResponseEntity<genericResponse> updateByUsername(@PathVariable("updatebyUsername") String username, @RequestBody registerRequest request){
        genericResponse response = registerService.updateBookByUserName(username, request);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
