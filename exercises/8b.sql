-- Yeah we didn't set up cascading deletes :'(
-- Could you delete Dua Lipa's albums, too?
-- Pretty sure her ID was 6M2wZ9GZgrQXHCFfjv46we
-- Don't worry about the tracks, I'll get someone else to do that. kthx!

DELETE FROM albums
WHERE artist_id = '6M2wZ9GZgrQXHCFfjv46we';
