package com.librarymanagementsystem.Registration;

import com.librarymanagementsystem.Dto.Response.genericResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class registerService {
    private final registerRepository registerRepository;

    public genericResponse getallusers(){
        List<registerRequest> getalluser = registerRepository.findAll();
        return new genericResponse("00",
                "ALL USERS",
                getalluser,
                null
        );
    }
    public genericResponse addDUser(registerRequest request){
        var exist = registerRepository.findByUserName(request.getUserName());
        if (exist == null){
                registerRequest registerRequest = new registerRequest();
                registerRequest.setFirstName(request.getFirstName());
                registerRequest.setLastName(request.getLastName());
                registerRequest.setEmail(request.getEmail());
                registerRequest.setUserName(request.getUserName());

                registerRepository.save(registerRequest);

                return new genericResponse("00",
                        "ADDED SUCCESSFULLY",
                        registerRequest,
                        null
                );
        }
        return new genericResponse("11",
                "BOOK ALREADY EXIST",
                null,
                null
        );
    }
    public genericResponse deleteallduser(){
        var exist = registerRepository.findAll();
        if (exist.isEmpty()){
            return new genericResponse("11",
                    "THE LIBRARY IS EMPTY",
                    null,
                    null
            );
        }
        registerRepository.deleteAll();
        return new genericResponse("00",
                "SUCCESSFULLY DELETED",
                exist,
                null
        );
    }
    public genericResponse deleteByUsername(String username){
        var exist = registerRepository.findByUserName(username);
        if (exist != null){
            registerRepository.delete(exist);

            return new genericResponse("00",
                    "DELETED SUCCESSFULLY",
                    exist,
                    null
            );
        }
        return new genericResponse("11",
                "BOOK DOES NOT EXIST",
                null,
                null
        );
    }
    public genericResponse updateBookByUserName(String username , registerRequest request){
        var exist = registerRepository.findByUserName(username);
        if (exist != null){
            exist.setFirstName(request.getFirstName());
            exist.setLastName(request.getLastName());
            exist.setEmail(request.getEmail());
            exist.setUserName(request.getUserName());

            registerRepository.save(exist);

            return new genericResponse("00",
                    "ADDED SUCCESSFULLY",
                    exist,
                    null
            );
        }
        return new genericResponse("11",
                "BOOK DOES NOT EXIST",
                null,
                null);
    }
}
