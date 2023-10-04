package com.ironhead;

import java.net.MalformedURLException;
import java.net.URI;
import  java.net.URL;
import java.net.URISyntaxException;

public class Main {
  public static void main(String[] args) {
    try {
      // Path to resource (db:). This cause an URL malformed exception.
//      URI uri = new URI("db://userName:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//      URI uri = new URI("wrongURIExample");
      URI baseUri = new URI("http://userName:password@myserver.com:5000");
      URI uri = new URI("/catalogue/phones?os=android#samsung");
      URI resolverUri = baseUri.resolve(uri);

      /*
      System.out.println("Scheme: " + uri.getScheme());
      System.out.println("Scheme-specific: " + uri.getSchemeSpecificPart());
      System.out.println("Autority: " + uri.getAuthority());
      System.out.println("User info: " + uri.getUserInfo());
      System.out.println("Host: " + uri.getHost());
      System.out.println("Port: " + uri.getPort());
      System.out.println("Path: " + uri.getPath());
      System.out.println("Query: " + uri.getQuery());
      System.out.println("Fragment: " + uri.getFragment());
       */

      URL url = resolverUri.toURL();
      System.out.println("URL: " + url);
    } catch (URISyntaxException e) {
      System.out.println("URI bad syntax: " + e.getMessage());
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    }
  }
}