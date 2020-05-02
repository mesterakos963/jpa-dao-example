package book;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        for (int i = 0; i < 25; i++) {
            bookDao.persist(BookGenerator.generateBook());
        }
        bookDao.findAll().stream().forEach(System.out::println);
    }
}