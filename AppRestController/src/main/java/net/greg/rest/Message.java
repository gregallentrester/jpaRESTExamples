package net.greg.rest;

public class Message implements TransientMarker {

  private String text;
  public String getText() { return text; }
  public void setText(String value) { text = value; }
}
