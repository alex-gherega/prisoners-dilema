# prisoners-dilema

A full environment for the prisoner's dilema game and tournament

Check out the [wiki](https://github.com/alex-gherega/prisoners-dilema/wiki)

# How to use

1. Checkout the project
2. Start you Clojure env & REPL
3. load-up tournament
4. call the function run with a number of turns

This will print at the end of the tournament something like:
({:alex 23} {:cata 30})

# Revamp the environment

Many fields are left hardcoded - e.g. the prisoners names, the choice symbols etc.

Feel free to add you parameterized environment and reuse the refry, history and strategies API.

# Strategies

The version a.0.0.1 contains only the basic random strategy.
If you would like to add some other strategies please add them under the strategy ns.
