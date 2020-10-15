file_path = ARGV[0] || "input.txt"
WORDS = {}
file = File.open(file_path, "r") 
 
file.each_line do |line|
  words = line.split 
  words.each do |word|
    word = word.gsub(/[,()'.;?!"]/,'').downcase
    if WORDS[word]
      WORDS[word] += 1
    else
      WORDS[word] = 1
    end
  end
end
 
WORDS.sort {|a,b| a[1] <=> b[1]}.each do |key,value|
  puts "#{key} => #{value}"
end
