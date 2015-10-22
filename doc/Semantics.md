# Semantics #

## Model-theoretic Semantics ##

A Flix program P is a finite set of rules. A rule is a horn clause and has the general shape:
A1 <= A2, ..., An where H, A, and B are predicate symbols. 

A model M of P is an interpretation. 

A model `M1` is equivalent to another model `M2` iff: 
For every ground fact `p(e, t1, .... , tn)` there exists a ground fact `p(e, t1', ...., tn')` in `M2`. 

A model `M1` is minimal if there exists no other model `M2` such `M1 != M2` 
and for every `p(e1, v2)` in `M2` and `p(e2, v2)` in `M2`: `e2 <= e1`.  

A constraint `c` is `true` iff:

1. `c = P(e, v).` and P(e, v) is in the model `M`. 

## Operational Semantics ##

## Language ##

We begin with a simplified grammar of the Flix language:

```
Program ::= <Constraints> ...
```

```
Constraint ::= <HeadPredicate> :- <Filter>, ..., <BodyPredicate>, ...
```

```
HeadPredicate ::= <Name> (<HeadTerm> ... )
BodyPredicate ::= <Name> (<BodyTerm> ... )
```


```
Literal ::= Unit
          | Bool
          | Int
          | Str
          | Tag Value
          | (Value ...)
```