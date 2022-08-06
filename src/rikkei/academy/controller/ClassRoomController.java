package rikkei.academy.controller;

import rikkei.academy.model.ClassRoom;
import rikkei.academy.service.Class_Room.ClassRoomServiceIMPL;
import rikkei.academy.service.Class_Room.IClassRoomService;

import java.util.List;

public class ClassRoomController {
    ClassRoomServiceIMPL classRoomService = new ClassRoomServiceIMPL();

    public List<ClassRoom> getClassRoomList() {
        return ClassRoomServiceIMPL.classRoomList;
    }

    public void createClassRoom(String classroomName) {
        classRoomService.save(new ClassRoom(ClassRoomServiceIMPL.classRoomList.size() + 1, classroomName));

    }

    public void editClassRoom(int id, String classroomName) {
        classRoomService.update(new ClassRoom(id, classroomName));

    }

    public void delete(int id) {
        classRoomService.deLete(id - 1);
        updateList(id - 1);
    }

    private void updateList(int index) {
        for (int i = 0; i < ClassRoomServiceIMPL.classRoomList.size(); i++) {
            ClassRoomServiceIMPL.classRoomList.get(i).setId(i + 1);

        }
    }
    public boolean contains(String name){
        for (ClassRoom classRoom: classRoomService.findall()){
            if (classRoom.getName().equals(name));
            return true;
        }
        return false;
    }
}
