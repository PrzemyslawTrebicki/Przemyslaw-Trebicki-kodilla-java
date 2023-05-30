package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    List<String> usersNames();      //lista nazw użytkowników
    int postCount();                //ilość wszystkich postów
    int commentsCount();            //ilość wszystkich komentarzy
}
