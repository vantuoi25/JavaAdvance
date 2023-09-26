package com.vti.frontend;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class Program {
    public static void main(String[] args) {

        GroupRepository groupRepository = new GroupRepository();

        Group group = new Group("Nguyen Van Tuoi");
        groupRepository.createGroup(group);
    }
}