.mode json

SELECT artists.name AS artist_name, COUNT(tracks.id) AS explicit_track_count
FROM artists
INNER JOIN albums on artists.id = albums.artist_id
INNER JOIN tracks ON albums.id = tracks.album_id
WHERE tracks.explicit = 1
GROUP BY artists.name
ORDER BY explicit_track_count DESC;