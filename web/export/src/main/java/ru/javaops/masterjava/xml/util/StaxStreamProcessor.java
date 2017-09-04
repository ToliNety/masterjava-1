package ru.javaops.masterjava.xml.util;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * gkislin
 * 23.09.2016
 */
public class StaxStreamProcessor implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public class ElementProcessor {
        private final String element;
        private final String parent;

        public ElementProcessor(String element, String parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean start() throws XMLStreamException {
            while (reader.hasNext()) {
                int event = reader.next();
                if (parent != null && isElementEnd(event, parent)) {
                    return false;
                }
                if (isElementStart(event, element)) {
                    return true;
                }
            }
            return false;
        }
    }

    public StaxStreamProcessor(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    public ElementProcessor elementProcessor(String element, String parent) {
        checkNotNull(element);
        return new ElementProcessor(element, parent);
    }

    private boolean isElementStart(int event, String el) {
        return event == XMLEvent.START_ELEMENT && el.equals(reader.getLocalName());
    }

    private boolean isElementEnd(int event, String el) {
        return event == XMLEvent.END_ELEMENT && el.equals(reader.getLocalName());
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    public boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == stopEvent && value.equals(getValue(event))) {
                return true;
            }
        }
        return false;
    }

    public String getAttribute(String name) throws XMLStreamException {
        return reader.getAttributeValue(null, name);
    }

    public String getValue(int event) throws XMLStreamException {
        return (event == XMLEvent.CHARACTERS) ? reader.getText() : reader.getLocalName();
    }

    public String getElementValue(String element) throws XMLStreamException {
        return doUntil(XMLEvent.START_ELEMENT, element) ? reader.getElementText() : null;
    }

    public String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                // empty
            }
        }
    }
}
