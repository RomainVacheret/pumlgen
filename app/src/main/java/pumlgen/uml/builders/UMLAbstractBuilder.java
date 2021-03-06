package pumlgen.uml.builders;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class UMLAbstractBuilder {
    public static final String TAB = "\t";
    public static final String NEW_LINE = "\n";
    public static final String TABBED_NEW_LINE = "\n\t";
    public static final String BRACKETS = "()";
    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String OPENING_BRACE = "{";
    public static final String CLOSING_BRACE = "}";

    private static Set<String> getStripedModifiers(Set<String> modifiers) {
        return  modifiers.stream()
            .map(String::strip)
            .collect(Collectors.toSet());
    }


    public static String getVisibilityModifierSymbol(Set<String> modifiers) {
        final Set<String> stripedModifiers = getStripedModifiers(modifiers);
        if(stripedModifiers.contains("public")) {
            return "+";
        }
        if(stripedModifiers.contains("private")) {
            return "-";
        }
        if(stripedModifiers.contains("protected")) {
            return "#";
        }
        return "~";
    }

    public static String getStaticOrAbstractModifiers(Set<String> modifiers) {
        final Set<String> stripedModifiers = getStripedModifiers(modifiers);
        if(stripedModifiers.contains("abstract")) {
            return "{abstract}";
        } else if(stripedModifiers.contains("static")) {
            return "{static}";
        } else {
            return "";
        }
    }

    public abstract String build();
}
