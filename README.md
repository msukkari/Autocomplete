# Autocomplete

The following is an autocomplete feature implemented in java using a trie. By using a trie, this program is able to fetch stored words that contain a given prefix. This program is my solution to an assignment given in my introduction to computer science class at McGill.

Here is the description of the question as giving on the assigment paper: ( http://www.cim.mcgill.ca/~langer/250/A3.pdf ) NOTE: The assignment file is hosted by McGill, and is subject to change; I apologize in advance if this link is broken.

#Question 1 Implementing Autocomplete with a Trie 

In this question, you will work on the problem of storing a set of n words (also called keys) in a
tree data structure, and a method for efficiently finding all the words that contain a given prefix.
By word or key here, we just mean a string formed from some set of ASCII characters. (If you
are unfamiliar with ASCII, see http://www.asciitable.com/. ASCII encodes text using one byte
or 8 bits per character.)
You should be familiar with the above problem through the autocomplete feature found on some
cell phones, web forms, Eclipse. For instance, if you type in “aar", then autocomplete may
suggest aardvark, aardvarks, aardwolf, aardwolves, aargh.



#Testing

The assignment came with a tester class which reads words from a file, fills a trie with the loaded keys, and then tests each method in the Trie class. Each method in the following implementation passes every test.
