.mode json

SELECT albums.name AS album_name,
AVG(features.loudness) AS average_loudness,
albums.release_date AS release_date
FROM albums
INNER JOIN tracks ON tracks.album_id = albums.id
INNER JOIN features ON tracks.id = features.track_id
GROUP BY albums.name
ORDER BY release_date ASC;