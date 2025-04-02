package org.acme;

import static java.util.Objects.requireNonNull;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class SomePage {

    private final Template spaces;
    private final Template tabs;

    public SomePage(Template spaces, Template tabs) {
        this.spaces = requireNonNull(spaces, "spaces is required");
        this.tabs = requireNonNull(tabs, "tabs is required");
    }

    @GET
    @Path("/spaces")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return spaces.instance();
    }

    @GET
    @Path("/tabs")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance tabs() {
        return tabs.instance();
    }
}
