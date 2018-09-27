## Exercise \#1
What is the difference between a ```KeyListener``` and a ```KeyAdapter```?

  A KeyListener is an interface that can be implemented by a programmer writting a keyboard event, while the abstract class KeyAdapter can be extended for a similar purpose. The benefit of a KeyListener is not requiring the user to write up the methods, merelly to implement them. The KeyAdapter allows the programmer to choose which methods they want and to customize them as needed for their purposes.

## Exercise \#2
What is the difference between a ```MouseListener``` and a ```MouseMotionListener```.

  A MouseListener trakcs actions on the mouse such as clicking, scrolling, etc. The MouseMotionListener on the other hand, as its name implies, tracks the actual motion of the mouse as the user moves it, or in some cases, the movement of the user's finger on a trackpad.

## Exercise \#3
Given a ```MouseEvent```, Java has the ```getButton``` and ```getModifiersEx``` methods for determining which mouse buttons are pressed. Are both methods really needed, that is, do they differ in any way?

  getButton performs a very specific purpose by getting the number of the button that has changed state, and returning a value based on which number button was pressed, and 0 if none were. getModifiersEx not only includes ALT, CTL, and META, but also gives the sequence in which the buttons were pressed, not just the single button. Thus getButton is used when figuring out which button is pressed, getModifiersEx is used when figuring out the sequence of buttons.

## Exercise \#4
What is meant by an event source, event listener, and event object?

  Put as simply as possible, an event source is produces an event, or is the origin of one, an event listener awaits an event to happen, usually so that it can then trigger something else, and an event object is the code born of the event happening, in other words the event as the program can process it.

## Exercise \#5
What is the purpose of an anonymous inner class? What would one use an anonymous inner class for?

  
