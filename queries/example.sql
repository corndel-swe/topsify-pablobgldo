-- To execute the query, open a terminal and run:
-- sqlite3 db/db.sqlite < queries/example.sql
.mode json

SELECT name, duration_ms
FROM tracks
LIMIT 5;

SELECT id, name
FROM tracks
WHERE album_id = '552zi1M53PQAX5OH4FIdTx';

SELECT users.username, playlists.name FROM playlists
INNER JOIN users ON users.id = playlists.user_id;

SELECT users.username, tracks.name
FROM users
INNER JOIN playlists ON users.id = playlists.user_id
INNER JOIN tracks ON tracks.id = playlist_tracks.track_id
INNER JOIN playlist_tracks ON playlists.id = playlist_tracks.playlist_id;

SELECT * FROM playlist_tracks;

