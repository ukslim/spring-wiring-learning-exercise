"Why Spring?" exercise
======================

This is an exercise for beginners to Spring dependency injection.

To complete it you will probably need to look elsewhere for Spring
documentation. A book about Spring, the official Spring docs, or just
whatever Google gives you, will do.

Before you start
----------------
Make sure you can build the project. If `mvn clean package` works, you're
ready.

Look at the interfaces in `me.jh.whyspring.components` and the
implementations in `impl` below. If it helps, draw a picture
showing how these implementations depend on one another.

In these exercises, do not modify the Java code for any of the classes
under `components`. The only Java you need to change is the **constructor**
of `CardApplication.java`.

Look at the requirements in `src/main/resources/requirements.txt`.

Task 1 - wiring by hand
-----------------------
Make the application pass the two requirements, by *only* editing
the constructor in `CardApplication.java`, replacing the line:

    shop = null; // replace this

Hints:

 - Work on one requirement at a time. As long as what you have
   compiles, you can run the application and get hints about what
   more needs to be done.
 - Usually these are `NullPointerExceptions` indicating that a
   field has not been set.

Once it's working, look at the code you have written:

 - How easy was it to write?
 - What challenges did you have while writing it?
 - Is it easy to understand now?

Task 2 - wiring with Spring
---------------------------
Comment out *all* the wiring code you wrote for task 1. Replace it with
this code, to create a Spring application context, and request that it
build you the `shop`

    ApplicationContext context =
            new ClassPathXmlApplicationContext("application-context.xml");
    shop = (CardShop) context.getBean("cardShop");

Make the program meet the requirements again, this time by editing
`src/main/resources/application-context.xml`.

Hints:

 - Because maps are slightly more complicated, your first bean
   definition is provided to get you started.
 - You will need to use `<bean>` elements containing `<property>`
   elements.
 - It will probaby be easiest if all your `<bean>` elements have
   an `id` attribute, so that you can use the `ref` attribute
   in `<property>` elements to configure properties which are
   other beans.
 - To represent a newline in XML attributes, use `&#10;`

Once it's working, reflect on what you've done.

 - Was it easier than task 1? Why? (or why not?)
 - Is the configuration you've written clearer than the code you
   wrote for task 1?  Why? (or why not?)

More things to try
------------------

 - Try adding a new type of card so that the command line parameters
   `birthdaybottle Charles` prints a picture of a bottle followed by
   "Happy birthday Charles". Do this without creating a new `GreetingService`
    bean.
 - Try adding a new kind of card that uses an existing picture and a new
   greeting.
 - Try changing one (or more) of the components by removing the setters
   and instead adding parameters to the constructor. What changes are
   necessary in the Spring configuration? Do you think this is a better or
   worse way? Why?
      - Yes, you're allowed to modify the components for this experiment
      - Look for `<constructor-arg>` in the Spring documentation

Concluding notes
================

This exercise has allowed you to experience what it's like to join
a collection of objects into a working system using plain Java.
Then it allowed you to let Spring do the same "wiring" according to an
XML configuration you supplied.

I think this is a good way to understand the value Spring adds by managing
**dependency injection**, that is, plugging objects into each other to create
a working system. Dependency injection is the "big idea" underlying almost
everything else Spring does.

In early versions of Spring, XML configuration is the main way things were
done. However you should be aware that this method has fallen out of
fashion. To really understand Spring, you need to learn about:

 - Java annotation based configuration - more or less equivalent to XML
   based configuration, but somewhat easier to read, and with some help
   from the Java type system.
 - auto-wiring and component scanning - in which, instead of specifying
   an exact bean in configuration, you allow Spring to find a bean that
   fits
