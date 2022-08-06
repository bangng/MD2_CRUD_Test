package rikkei.academy.service.Class_Room;

import rikkei.academy.model.ClassRoom;
import rikkei.academy.service.IGeneri;

public interface IClassRoomService extends IGeneri<ClassRoom> {
    void update(ClassRoom classRoom);

    void deLete(int index);
}
