package rikkei.academy.service.Class_Room;

import rikkei.academy.model.ClassRoom;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomServiceIMPL implements IClassRoomService{
    public static List<ClassRoom> classRoomList = new ArrayList<ClassRoom>(){
        @Override
        public String toString() {
            String list = "ClassRoom List: \n";
            list += "======================= \n";
            for (ClassRoom classRoom : this){
                list += classRoom.toString() + "\n";

            }
            list += "======================== \n";
            return list;

        }
    };


    static {
        classRoomList.add(new ClassRoom(1,"JVa123"));
        classRoomList.add(new ClassRoom(2,"JVa234"));
}

    @Override
    public List<ClassRoom> findall() {
        return classRoomList;
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRoomList.add(classRoom);

    }

    @Override
    public void update(ClassRoom classRoom) {
        classRoomList.get(classRoom.getId() - 1).setName(classRoom.getName());

    }


    @Override
    public void deLete(int index) {
        classRoomList.remove(index);



    }
}
