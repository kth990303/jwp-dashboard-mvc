package nextstep.mvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    private final View view;
    private final Map<String, Object> model;

    public ModelAndView(final View view) {
        this.view = view;
        this.model = new HashMap<>();
    }

    public ModelAndView(final String viewName) {
        this.view = new JspView(viewName);
        this.model = new HashMap<>();
    }

    public void addObject(final String attributeName, final Object attributeValue) {
        model.put(attributeName, attributeValue);
    }

    public void render(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        view.render(model, request, response);
    }

    public Object getObject(final String attributeName) {
        return model.get(attributeName);
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public View getView() {
        return view;
    }
}
