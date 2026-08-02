# Write your MySQL query statement below
SELECT Person.firstName,person.lastName,Address.city,Address.state   
from Person
left join Address
on Person.personId=Address.personId;