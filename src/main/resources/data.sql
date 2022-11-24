-- Franchise
INSERT INTO franchise(fran_name, franchise_description) VALUES ('Marvel', 'The largest Super Hero Franchise out there'),
                                                               ('Disney', 'A well of warm animated stories for the whole family'),
                                                               ('Halloween', 'A classic horror genre that inspired lots of other movies');


-- Actors
INSERT INTO actor(actor_name, actor_description) VALUES ('Chris Evans', 'Got famous for his Ct. America role'),
                                                        ('Jamie Foxx', 'We all remember him from Django unchained'),
                                                        ('Jamie Lee Curtis', 'Played Laurie Strode in the Halloween movies');

-- Director
INSERT INTO director(director_name) VALUES ('Joe Johnston'),
                                           ('Pete Docter'),
                                           ('John Carpenter');

INSERT INTO movie(MOVIE_NAME, MOVIE_DESCRIPTION, MOVIE_HOURS, MOVIE_MINUTES, MOVIE_AGE, DIRECTOR_ID, FRAN_ID) VALUES
                ('Captain America', 'The origin story of Captain America', 2, 3, 16, 1, 1),
                ('Soul', 'A story about a jazz pianist', 2, 20, 5, 2, 2),
                ('HalloweenT', 'The first movie in the series', 1, 31, 18, 3, 3);

INSERT INTO movie_actor(movie_id, actor_id) VALUES (1,1), (2,2), (3,3);





