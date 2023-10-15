package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class SchoolModule extends AbstractModule {

    @Provides
    public IPersistenceManager providePersistenceManager(SerializablePersistenceManager manager){
        return manager;
    }

    @Provides
    @Named("classesStorage")
    public String provideClassesStorageName(){return "classes2.dat";}

    @Provides
    @Named("teachersStorage")
    public String provideTeachersStorageName(){return "teachers2.dat";}


}
