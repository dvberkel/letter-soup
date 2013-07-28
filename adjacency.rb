#! /usr/bin/env ruby

def in_agreement(word, candidate)
  word_letters = word.split("")
  for first_index in (0..(word_letters.length-2)) do
    first = word_letters[first_index]
    for second_index in (first_index .. (word_letters.length-1)) do
      second = word_letters[second_index]
      if (first != second) then
        first_location = candidate.index(first)
        second_location = candidate.index(second)
        if (first_location and second_location and first_location > second_location) then
          return false
        end
      end
    end
  end
  true
end

words = []
File.open('words.txt').each_line do |line|
  words << line.chomp
end

f = File.open('adjacency.txt', 'w+')

for word in words do
  f.write("#{word}:#{word}")
  for candidate in words do
    if in_agreement(word, candidate) then
      f.write(",#{candidate}")
    end
  end
  f.write("\n")
  f.flush()
end
