package ci.gouv.dgbf.service;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class AppLifsCycle {
    private static final Logger LOG = Logger.getLogger("ListenerBean");
    @Inject
    VisaSequenceService visaSequenceService;

    void onStart(@Observes StartupEvent event){
        visaSequenceService.init();
        LOG.info("Visa sequence initialised");
    }

    void onStop(@Observes ShutdownEvent event) {
        LOG.info("The application is stopping...");
    }
}
