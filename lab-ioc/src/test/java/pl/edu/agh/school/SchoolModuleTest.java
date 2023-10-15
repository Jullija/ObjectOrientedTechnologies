package pl.edu.agh.school;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.agh.logger.Logger;
import pl.edu.agh.school.guice.SchoolModule;

public class SchoolModuleTest {

    @Test
    public void loggerSingletonTest(){
        Injector injector = Guice.createInjector(new SchoolModule());
        Logger log1 = injector.getInstance(Logger.class);
        Logger log2 = injector.getInstance(Logger.class);
        Assertions.assertSame(log1, log2);

    }
}
