# Turnstile

“Turnstile” is a simple program which tries to emulate the behaviour of a real life turnstile gate. It uses Enumeration based finite state machine for managing the state of the turnstile gate.

## General information

The turnstile can be in three states : Locked, Paid and Open.
The Turnstile object is initialized in Locked state by default and exposes three methods: 
- boolean putCoin(): attempts insertion of a coin.
- boolean canPass(): attempts passing through the gate.
- key(): locks/unlocks the gate.


## In Locked state

- Inserting coins is allowed once and the state is changed to Paid.
- Passing through the gate is not allowed and the status doesn't change.
- Using the key changes the state to Open.

## In Paid state

- Inserting coins is not allowed and the state doesn't change.
- Passing through the gate is allowed once and the state changed to Locked.
- Using the key changes the state to Open.


## In Open state

- Inserting coins is not allowed and the state doesn't change.
- Passing through the gate is allowed multiple times and the state doesn't change.
- Using the key changes the state to Locked.


  
### Used Tools
```
- Java
- Maven
- JUnit
```
