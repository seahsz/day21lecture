package vttp.paf.day21lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.paf.day21lecture.model.Room;
import vttp.paf.day21lecture.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.getRooms();
    }
    
}
