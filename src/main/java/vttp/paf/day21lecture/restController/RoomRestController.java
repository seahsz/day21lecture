package vttp.paf.day21lecture.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.paf.day21lecture.model.Room;
import vttp.paf.day21lecture.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomSvc;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomSvc.getAllRooms();

        return ResponseEntity.ok().body(rooms);
    }
    
}
